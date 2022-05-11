<template>
<div class="page_width">
  <el-table
    :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    ref="multipleTable"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"> </el-table-column>
    <el-table-column prop="name" label="name" width="200"></el-table-column>
    <el-table-column prop="Composer" label="Composer" width="120"> </el-table-column>
    <el-table-column label="movement">
         <template slot-scope="scope">
                <div>
                  <ul>
                    <li v-for="item in scope.row.movements" :key="item.movement">
                      {{ item.movement }}
                    </li>
                  </ul>
                </div>
              </template>
    </el-table-column>
    <el-table-column prop="Introduction" label="Introduction" width="120"></el-table-column>

    <el-table-column
      label="tags"
      :filters="[{ text: 'cello', value: 'cello' }, { text: 'mozart', value: 'mozart' },{ text: 'Snatas', value: 'Snatas' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template >
      </template>
      <template slot-scope="scope">
            <div>
              <el-tag :type="success" v-for="item in scope.row.tags" :key="item.tag"
                disable-transitions>
                {{item.tag}}
              </el-tag>
            </div>
      </template>
    </el-table-column>
    <el-table-column align="right">
        <template slot="header" \>
        <el-input
          v-model="search"
          size="mini"
          placeholder="search..."/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Del</el-button>
      </template>
    </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data () {
    return {
      tableData: [
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        }
      ],
      search: '',
      multipleSelection: []
    }
  },

  methods: {
    toggleSelection (rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    filterTag (value, row) {
      return row.tags === value
    }
  }
}

</script>

<style>
</style>
